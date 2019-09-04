CREATE TABLE orders
(
    order_id integer primary key
);

CREATE TABLE items
(
    item_id  integer primary key,
    name     varchar(30) NULL,
    price    bigint      NULL,
    provider varchar(30) NULL,
    country   varchar(30) NULL,
    type     varchar(30) NULL,

    order_id integer  not null references orders(order_id)
);


INSERT INTO orders (order_id) VALUES (1);

INSERT INTO items (item_id, name, price, provider, country, type, order_id)
VALUES (1, 'koffee', 30, 'provider', 'russia', 'DRINK', 1);
INSERT INTO items (item_id, name, price, provider, country, type, order_id)
VALUES (2, 'tea', 5, 'provider', 'russia', 'DRINK', 1);

