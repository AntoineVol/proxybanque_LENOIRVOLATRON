

--Client
INSERT INTO `client` (`id`, `birthday`, `clientAccount`, `firstName`, `lastName`, `address_id`) VALUES
(1, '1991-12-10', 10121991, 'Antoine', 'Volatron', NULL);
INSERT INTO `client` (`id`, `birthday`, `clientAccount`, `firstName`, `lastName`, `address_id`) VALUES
(2, '1991-12-11', 11121991, 'Tim', 'Burton', NULL);
INSERT INTO `client` (`id`, `birthday`, `clientAccount`, `firstName`, `lastName`, `address_id`) VALUES
(3, '1991-12-11', 11121992, 'Tim', 'Burton', NULL);
INSERT INTO `client` (`id`, `birthday`, `clientAccount`, `firstName`, `lastName`, `address_id`) VALUES
(4, '1991-12-12', 12121991, 'Jean-Pierre', 'Volatron', NULL);
INSERT INTO `client` (`id`, `birthday`, `clientAccount`, `firstName`, `lastName`, `address_id`) VALUES
(5, '1991-12-10', 10151991, 'Antoine', 'Dujardin', NULL);




INSERT INTO `address` (`id`, `addressLine1`, `addressLine2`, `city`, `country`, `postalCode`, `client_id`) VALUES
(1, '51 chemin des bouleaux', '1 etage', 'Poisy', 'France', '74330', 1);

INSERT INTO `bankaccount` (`type`, `id`, `balance`, `creationDate`, `numAccount`, `chequeBook_id`, `client_id`, `bankCard_id`) VALUES ('CURRENT_ACCOUNT', 1, 500, '2018-07-06', 128568745, NULL, 1, NULL ), ('SAVING_ACCOUNT', 2, 500, '2018-07-06', 128568745, NULL, 1, NULL ), ('CURRENT_ACCOUNT', 3, 500, '2018-07-06', 128568745, NULL, 1, NULL ), ('SAVING_ACCOUNT', 4, 500, '2018-07-06', 128568745, NULL, 2, NULL ), ('CURRENT_ACCOUNT', 5, 500, '2018-07-06', 128568745, NULL, 2, NULL ), ('SAVING_ACCOUNT', 6, 500, '2018-07-06', 128568745, NULL, 3, NULL), ('CURRENT_ACCOUNT', 7, 500, '2018-07-06', 128568745, NULL, 4, NULL ), ('SAVING_ACCOUNT', 8, 500, '2018-07-06', 128568745, NULL, 5, NULL), ('CURRENT_ACCOUNT', 9, 500, '2018-07-06', 128568745, NULL, 4, NULL ), ('SAVING_ACCOUNT', 10, 500, '2018-07-06', 128568745, NULL, 4, NULL) 

