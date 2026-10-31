# Class Responsibilities

## 1. Purpose

This document defines the responsibilities of each class in the Library Management System.

Each class should have a clear purpose and should manage only the information and behavior related to that purpose.

The goal is to establish clear separation of responsibilities, reduce unnecessary dependencies, and make the system easier to maintain and extend.

## 2. Identified Classes

The system will initially contain the following classes:

| Class | Classification |
|---|---|
| `Member` | Core domain class |
| `LibraryItem` | Core domain class |
| `BorrowingTransaction` | Core domain class |
| `LateFeeCalculator` | Supporting class |