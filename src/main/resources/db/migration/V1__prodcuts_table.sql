CREATE TABLE public.PRODUCT
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(255)   NOT NULL,
    description VARCHAR(255),
    price       DECIMAL(10, 2) NOT NULL,
    CREATED_AT  TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    Modified_AT TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO public.PRODUCT (name, description, price)
VALUES ('Product 1', 'Description of Product 1', 10.99),
       ('Product 2', 'Description of Product 2', 19.99),
       ('Product 3', 'Description of Product 3', 29.99);