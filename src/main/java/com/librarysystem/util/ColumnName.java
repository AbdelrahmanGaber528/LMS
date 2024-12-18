package com.librarysystem.util;

public enum ColumnName {
    // Book

    // TRANSACTION
    TRANSACTION_ID,
    BOOK_ID,//0
    PATRON_ACCOUNT_ID,//1
    LIBRARIAN_ACCOUNT_ID,
    ISSUE_DATE,
    RETURN_DATE,
    BOOK_TITLE ,
    TOTAL_AMOUNT,

    // Book continue
    BOOK_AUTHOR,
    BOOK_PRICE,
    CATEGORY,
    STATUS,
    AMOUNT,

    // Admin
    ADMIN_Account_ID,

    // ACCOUNT
    USER_ID,
    USER_NAME ,
    PASSWORD,
    ROLE,
    CONTACT,
    PREFERENCES,
    IS_ACTIVE, TITLE, AUTHOR, GENRE, PRODUCTION_DATE, IS_AVAILABLE,


}