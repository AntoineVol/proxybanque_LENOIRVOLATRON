# ProxyBanque Version 3                                             								06/07/2018
Antoine Volatron et Fabien Lenoir
-----------------------------------------------------------------------------------------------------------------

# I_Introduction

L'application ProxyBanque V3 permets aux clients de se connecter 
et d'effectuer des actions sur leurs comptes associés.

# II_Fonctionnalités

Le client peut : 
- s'Authentifier
- Lire ses informations (liste des comptes)
- Retirer de l'argent sur un compte courant
- Retirer un chèque
- Retirer une carte bleue
- Effectuer des virements compte à compte

# III_Installation
Les diagrammes de classes et sql sont dans le dossier "Util"
Pour utiliser ProxiBanqueV3 : 
** ------ Installer l'application ------ *
1) déziper dans un dossier le fichier "Proxibanque_V3_AVOFLE.zip"
2) ouvrir une console
3) aller jusqu'au dossier source de proxibanque.
4) taper : mvn clean package 
6) puis : xcopy /Y /Q target\proxibanque.war S:\apache-tomcat-8.5.31\webapps\proxibanque.war

** ------ Créer la base de donnée MySQL ------ *
1) Ouvrir Xampp
2) Lancer Apache
3) Lancer MySQL
4) Lancer le controle Admin de MySQL sur Xampp
5) Cliquer sur l'onglet "console" de Xampp
6) taper : "mysql -u root -p" puis tapez [entrée]
7) Dans le dossier PB_V2_AVOFLE, ouvrir le dossier Util et ouvrez dans un éditeur texte le fichier "CreationDBProxBanque_V2.sql"
8) Copier l'entièreté du fichier
9) Dans la console, coller le texte copié.
10) La base de donnée a été crée dans MySQL.

** ------ Lancer l'application ------ *
1) Lancer TomCat "tomcat-8.5.31"
2) Ouvrez un navigateur internet
3) Tapez dans l'url : http://localhost:8080/proxybanque_LENOIRVOLATRON/

# IV_Utilisation

Au démarrage l'application ProxiBanqueV3 affiche une page où le Nom et le Prénom du client est demandé.
Une fois le prénom et/ou le nom validé, une nouvelle page est affichée. Elle demande au client de renseigner 
une date de naissance afin de sélectionner un client unique.

 	- client test:
		** Prénom :"Tim" **			
		** Nom : "Burton" **
		** date : "1991-12-11" **
	
A chaque erreur, une notification spécifique s'affiche.. 
		
** Une fois identifié **

Une page la liste des comptes du client est affichée.
Ses comptes courant et épargnes.

** Plusieurs choix s'offrent à vous : ** 
		
   	- [effectuer un retrait] : /!\ le bouton ne s'affiche QUE sur un compte courant
		#  Une fois cliqué une nouvelle page apparait permettant d'effectuer plusieurs sortes de retraits. 
		- RETRAIT EN LIQUIDE
			/!\ Vous ne pourrez par retirer une somme strictement inférieur ou égal à 300€.
		- RETRAIT D'UNE CARTE BANCAIRE
			- Vous choisissez une nouvelle carte bleue pour le compte sélectionné (Carte Visa Electron ou Premier)
			/!\ Vous ne pourrez retirer une carte bleue que si l’ancienne est expirée 
		- RETRAIT D'UN CHEQUIER
			- Vous ne pourrez retirer un nouveau chéquier que si le dernier retrait date de plus de 3mois

   	- [Virement] : effectuer un virement
		# Une fois cliqué une nouvelle page s'affiche.
		# Il vous est alors demandé de sélectionner un compte à débiter et un compte à créditer.
		- VIREMENT : 
		/!\ Vous ne pourrez effectuer de virement si :
			- le montant du retrait dépasse le solde du compte débiteur 
			- vous tentez de retirer une somme de 900€ ou plus. 