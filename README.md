# SpringCloud-MicroServices-Angular
### Gestion d'une Plateforme d'E-commerce Distribuée (MicroServices+ Angular) 

#  Architecture micro-services : 

## Config-Service :
#### Rôle :
Le service de configuration (Config-Service) est responsable de la gestion dynamique des configurations de l'ensemble du système.
#### Fonctionnalités : 
Il stocke et distribue les configurations nécessaires aux autres services, permettant ainsi des mises à jour en temps réel sans nécessiter le redéploiement de l'ensemble de l'application.
## Customer-Service :
#### Rôle : 
Le service client (Customer-Service) gère les informations relatives aux clients, y compris les détails personnels et l'historique d'achat.
#### Fonctionnalités :
Il permet la création de nouveaux profils clients, la mise à jour des informations personnelles, et la récupération des historiques d'achat. Il interagit également avec d'autres services pour garantir une expérience utilisateur complète.
## Order-Service :
#### Rôle : 
Le service de commande (Order-Service) gère le cycle de vie complet des commandes, de la création à la livraison.
#### Fonctionnalités :
Il prend en charge la création de nouvelles commandes, le suivi de leur statut, la gestion des paiements, et la coordination avec d'autres services tels que le service d'inventaire.
## Gateway :
#### Rôle : 
La passerelle (Gateway) sert de point d'entrée unique pour les requêtes externes, agissant comme un point d'accès sécurisé pour l'ensemble du système.
#### Fonctionnalités :
 Elle gère le routage des requêtes vers les services appropriés, effectue la vérification d'authentification, et gère la sécurité des communications.
## Inventory-Service :
#### Rôle : 
Le service d'inventaire (Inventory-Service) est chargé de gérer les informations relatives aux stocks de produits.
#### Fonctionnalités :
 Il assure la disponibilité des produits, gère les niveaux de stock, et communique avec d'autres services tels que le service de commande pour garantir la synchronisation entre les commandes et les stocks.


