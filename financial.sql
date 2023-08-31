DROP DATABASE IF EXISTS conygre;
CREATE DATABASE conygre;
USE conygre;

CREATE TABLE stock
(
    stock_ticker	 varchar(11)		 NOT NULL,
    volume           int                 NOT NULL,
    close_price      decimal(10, 2)      NULL,
    time_stamp       varchar(25)         NULL,
    PRIMARY KEY(stock_ticker)
);

CREATE TABLE bond (
    bond_name       VARCHAR(255)        NOT NULL,
    maturity_date   VARCHAR(25)         NOT NULL,
    interest_rate   DECIMAL(5, 2)       NOT NULL,
    principal       DECIMAL(10, 2)      NOT NULL,
    PRIMARY KEY(bond_name)
);

CREATE TABLE cash (
    bank_name       VARCHAR(255)        NOT NULL,
    cash_amount     DECIMAL(10, 2)      NOT NULL,
    currency        VARCHAR(3)          NOT NULL,
    PRIMARY KEY(bank_name)
);

INSERT INTO stock (stock_ticker, volume) VALUES
('GOOGL', 500),
('TSLA', 300),
('NFLX', 150),
('MSFT', 750),
('NVDA', 600);

INSERT INTO bond (bond_name, maturity_date, interest_rate, principal) VALUES
('US Treasury Note', '2023-12-31', 1.75, 1000),
('Corporate Bond', '2025-06-15', 3.25, 2000),
('Municipal Bond', '2024-08-20', 2.50, 3000);


INSERT INTO cash(bank_name, cash_amount, currency) VALUES
('Bank of Montreal','10000','CAD'),
('Bank of America','20000','USD'),
('TD Bank','40000','CAD'),
('CIBC','60000','CAD');

