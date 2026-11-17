package library.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import library.model.BorrowingTransaction;

public class LateFeeCalculator {

	private static final double DAILY_RATE = 5.0;

	public double calculateLateFee(BorrowingTransaction transaction) {
		LocalDate effectiveDate;
		if (transaction.isActive()) {
			effectiveDate = LocalDate.now();
		} else {
			effectiveDate = transaction.getReturnDate();
		}

		long overdueDays;
		if (effectiveDate.isAfter(transaction.getDueDate())) {
			overdueDays = ChronoUnit.DAYS.between(transaction.getDueDate(), effectiveDate);
		} else {
			overdueDays = 0;
		}

		throw new UnsupportedOperationException("Not implemented yet.");
	}

}