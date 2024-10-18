
CREATE TABLE IF NOT EXISTS public.PRODUCT
(
    id          integer NOT NULL,
    name        VARCHAR(255)   NOT NULL,
    description VARCHAR(255),
    price       DECIMAL(10, 2) NOT NULL,
    CONSTRAINT products_pkey PRIMARY KEY (id)
);

INSERT INTO public.PRODUCT (id,name, description, price)
VALUES (1,'Product 1', 'Description of Product 1', 10.99),
       (2,'Product 2', 'Description of Product 2', 19.99),
       (3,'Product 3', 'Description of Product 3', 29.99);

