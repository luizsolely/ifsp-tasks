CREATE TABLE IF NOT EXISTS salesman (
    salesman_id NUMERIC(5) PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    city VARCHAR(15) NOT NULL,
    commission DECIMAL(5,2) NOT NULL,
    CONSTRAINT ck_salesman_id CHECK (salesman_id BETWEEN 1 AND 99999),
    CONSTRAINT ck_salesman_commission CHECK (commission >= 0)
);

CREATE TABLE IF NOT EXISTS customer (
    customer_id NUMERIC(5) PRIMARY KEY,
    cust_name VARCHAR(30) NOT NULL,
    city VARCHAR(15) NOT NULL,
    grade NUMERIC(3) NOT NULL,
    salesman_id NUMERIC(5) NOT NULL,
    CONSTRAINT ck_customer_id CHECK (customer_id BETWEEN 1 AND 99999),
    CONSTRAINT ck_customer_grade CHECK (grade BETWEEN 0 AND 999),
    CONSTRAINT fk_customer_salesman
        FOREIGN KEY (salesman_id) REFERENCES salesman (salesman_id)
);

CREATE TABLE IF NOT EXISTS orders (
    ord_no NUMERIC(5) PRIMARY KEY,
    purch_amt DECIMAL(8,2) NOT NULL,
    ord_date DATE NOT NULL,
    customer_id NUMERIC(5) NOT NULL,
    salesman_id NUMERIC(5) NOT NULL,
    CONSTRAINT ck_order_no CHECK (ord_no BETWEEN 1 AND 99999),
    CONSTRAINT ck_order_amount CHECK (purch_amt >= 0),
    CONSTRAINT fk_order_customer
        FOREIGN KEY (customer_id) REFERENCES customer (customer_id),
    CONSTRAINT fk_order_salesman
        FOREIGN KEY (salesman_id) REFERENCES salesman (salesman_id)
);
