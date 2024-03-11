
drop table if exists transactions;
drop table if exists accounts;
drop table if exists customers;

create table customers
(
    id           int         not null,
    first_name   varchar(50) not null,
    last_name    varchar(50) not null,
    age          int         not null,
    email        varchar(50) not null,
    country      varchar(50) not null,
    postal_code  varchar(50),
    phone_number varchar(50) not null,
    primary key (id)
);

create table accounts
(
    id             int         not null,
    customer_id    int         not null,
    account_number varchar(50) not null,
    currency       varchar(50) not null,
    card_number    varchar(50) not null,
    card_type      varchar(50) not null,
    primary key (id),
    foreign key (customer_id) references customers (id)
);

create table transactions
(
    id               int           not null,
    sender_id        int           not null,
    recipient_id     int           not null,
    amount           decimal(7, 2) not null,
    fee              decimal(7, 2) not null,
    address          varchar(50)   not null,
    country          varchar(50)   not null,
    approval_status  varchar(50)   not null,
    approval_date    datetime      not null,
    transaction_date datetime      not null,
    status           varchar(50)   not null,
    category         varchar(50)   not null,
    primary key (id),
    foreign key (sender_id) references accounts (id),
    foreign key (recipient_id) references accounts (id)
);
