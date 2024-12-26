package com.lms.util;

public enum ColumnName {
    // Book

    // TRANSACTION
    TRANSACTION_ID,
    PATRON_ACCOUNT_ID,//1
    BOOK_ID,//0
    ISSUE_DATE,
    RETURN_DATE,
    RETURNED,

    // Admin
    ADMIN_Account_ID,

    //Librarian

    LIBRARIAN_ACCOUNT_ID,

    // ACCOUNT
    USER_ID,
    USER_NAME ,
    PASSWORD,
    ROLE,
    CONTACT,
    PREFERENCES,
    IS_ACTIVE,

    // Book,
    BOOK_TITLE ,
    AUTHOR,
    GENRE,
    PRODUCTION_DATE,
    IS_AVAILABLE,
    AMOUNT,

}