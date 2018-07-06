--Client
INSERT INTO `client` (`id`, `birthday`, `clientAccount`, `firstName`, `lastName`, `address_id`) VALUES (NULL, '1991-12-10', '10121991', 'Antoine', 'Volatron', NULL);
--Address
INSERT INTO `address` (`id`, `addressLine1`, `addressLine2`, `city`, `country`, `postalCode`, `client_id`) VALUES (NULL, '51 chemin des bouleaux', '1 etage', 'Poisy', 'France', '74330', '1');
--Compte
