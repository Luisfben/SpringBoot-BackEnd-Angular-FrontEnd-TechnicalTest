INSERT INTO CLIENTS (ID, NAME) VALUES (16536990, 'LUIS BENAVIDES');
INSERT INTO CLIENTS (ID, NAME) VALUES (11223344, 'JUAN CASTRO');

INSERT INTO PRODUCTS (DESCRIPTION, PRICE) VALUES ('1 LB RICE', 1000);
INSERT INTO PRODUCTS (DESCRIPTION, PRICE) VALUES ('1 LB SUGAR', 1500);
INSERT INTO PRODUCTS (DESCRIPTION, PRICE) VALUES ('500 GRS DETERGENT FAB', 1000);

INSERT INTO KARDEX (ID_PRODUCT, TYPE_TRANSACTION, ID_TRANSACTION, QUANTITY, PRICE) VALUES (1,'ORD', 1, 10, 1000);
INSERT INTO KARDEX (ID_PRODUCT, TYPE_TRANSACTION, ID_TRANSACTION, QUANTITY, PRICE) VALUES (1,'VEN', 1, -5, 1000);
INSERT INTO KARDEX (ID_PRODUCT, TYPE_TRANSACTION, ID_TRANSACTION, QUANTITY, PRICE) VALUES (2,'ORD', 1, 2, 1000);
INSERT INTO KARDEX (ID_PRODUCT, TYPE_TRANSACTION, ID_TRANSACTION, QUANTITY, PRICE) VALUES (2,'VEN', 1, -1, 1000);