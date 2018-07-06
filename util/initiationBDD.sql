

--Client--
INSERT INTO `client` (`id`, `birthday`, `clientAccount`, `firstName`, `lastName`, `address_id`) VALUES
(1, '1991-12-10', 10121991, 'Antoine', 'Volatron', NULL),
(2, '1991-12-11', 11121991, 'Tim', 'Burton', NULL),
(3, '1991-12-11', 11121991, 'Tim', 'Burton', NULL),
(4, '1991-12-12', 12121991, 'Jean-Pierre', 'Volatron', NULL),
(5, '1986-03-14', 10151991, 'Fab', 'Fab', NULL);

--Address--
INSERT INTO `address` (`id`, `addressLine1`, `addressLine2`, `city`, `country`, `postalCode`, `client_id`) VALUES
(1, '51 chemin des bouleaux', '1 etage', 'Poisy', 'France', '74330', 1),
(2, '48 rue de la Traquette', '3 etage', 'Angers', 'France', '49000', 2),
(3, '12 rue des Soeurs', 'rez de chaussé', 'Lyon', 'France', '69100', 3),
(4, '18 rue de la chambre', '10 etage', 'Grenoble', 'France', '74000', 4),
(5, '58 rue de la Haute', '5 etage', 'Paris', 'France', '75600', 5);

--Carte Bancaire POUR Test--
INSERT INTO `bankcard` (`typeBankCard`, `id`, `expirationDate`, `numBankCard`, `currentAccount_id`) VALUES
('VISA_PREMIER', 1, '2019-07-06', 30, 5),
('VISA_PREMIER', 2, '2016-07-06', 30, 1);
--Chequier POUR TEST--
INSERT INTO `chequebook` (`id`, `receptionDate`, `sendDate`, `bankAccount_id`) VALUES
(1, '2016-09-03', '2017-10-01', 1);

--Account--
INSERT INTO `bankaccount` (`type`, `id`, `balance`, `creationDate`, `numAccount`, `chequeBook_id`, `client_id`, `bankCard_id`) VALUES
('CURRENT_ACCOUNT', 1, 500, '2018-07-06', 128568745, 1, 1, 2 ), 
('SAVING_ACCOUNT', 2, 500, '2018-07-06', 128568745, NULL, 1, NULL ), 
('CURRENT_ACCOUNT', 3, 500, '2018-07-06', 128568745, NULL, 1, NULL ), 
('SAVING_ACCOUNT', 4, 500, '2018-07-06', 128568745, NULL, 2, NULL ), 
('CURRENT_ACCOUNT', 5, 500, '2018-07-06', 128568745, NULL, 2, NULL ), 
('SAVING_ACCOUNT', 6, 500, '2018-07-06', 128568745, NULL, 3, NULL), 
('CURRENT_ACCOUNT', 7, 500, '2018-07-06', 128568745, NULL, 4, NULL ), 
('CURRENT_ACCOUNT', 8, 500, '2018-07-06', 128568745, NULL, 4, NULL ), 
('CURRENT_ACCOUNT', 9, 500, '2018-07-06', 128568745, NULL, 5, NULL ), 
('CURRENT_ACCOUNT', 10, 500, '2018-07-06', 128568745, NULL, 5, NULL ),
('SAVING_ACCOUNT', 11, 500, '2018-07-06', 128568745, NULL, 5, 2); 

