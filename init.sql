CREATE TABLE customers
(
    id        BIGSERIAL PRIMARY KEY NOT NULL,
    full_name VARCHAR(256)          NOT NULL,
    country   VARCHAR(64)           NOT NULL,
    state     VARCHAR(64)           NOT NULL,
    city      VARCHAR(64)           NOT NULL,
    zip       VARCHAR(16)           NOT NULL
);

INSERT INTO customers(full_name, country, state, city, zip)
VALUES ('Kiryl Bahushevich', 'Belarus', 'Minsk', 'Minsk', '220222'),
       ('Test Test', 'Belarus', 'Minsk', 'Minsk', '220111');