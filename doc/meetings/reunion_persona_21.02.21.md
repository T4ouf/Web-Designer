# Web Designer - Réunion du 21/02/21

## Objet : présentation et définition des besoins utilisateurs

Types d’utilisateurs (= personae) :
1.	**Designer** : Besoin de créer un site mais n’a pas les compétences techniques de développement
2.	**Développeur** : code les comportements du site mais n’a pas d’initiative au niveau design d’interface
3.	**Technical artist / Prototypeur** : entre les deux – a besoin d’un certain niveau de contrôle, mais veut pouvoir designer tout de même rapidement son interface

Tout le monde a accès à tous les panneaux, mais certains seront plus utiles à certaines personae qu’à d’autres. 

Typiquement, les panneaux les plus utilisés par chaque persona sont :

1.	**Designer** :
Panneau runtime web, liste des widgets, liste des fichiers (accès aux ressources, vidéos, images…) 

=> Utilise bcp le système de drag’n’drop, de palettes de couleurs

*Remarque : peut-être utile de permettre au designer de créer une palette de couleur. C’est le système de styles et super-styles vus à la présentation générale. Ces derniers permettraient aussi de sauvegarder un layout de site par exemple*

2.	**Développeur** :
IDE (éditeur de texte), console pour débogage & inspecteur etc., performances, arborescence des fichiers, page de documentation (ex MSDN)

*Remarque : pourquoi ne pas intégrer directement VS Code ? Réponse : plus intéressant de tout faire soi-même, mais on pourrait aussi proposer à l’utilisateur d’intégrer le système de son choix* 

3.	**Technical Artist** :
Gros œuvre en drag’n’drop donc widgets + runtime, et IDE pour les détails, console pour débogage, liste des fichiers

*Remarque : comment laisser l’utilisateur choisir les panneaux qu’il veut afficher ? A réfléchir lors du design des interfaces.*

*Remarque post-réunion : est-ce qu’il sera possible de modifier les widgets ? Si oui, dans un panneau différent des autres (et donc une nouvelle spec à écrire) ? Réponse : à priori non, mais on pourra les paramétrer. Idée intéressante à garder dans un coin de la tête*


> Idées intéressantes évoquées pendant la réunion :
> - Façon de modifier/paramétrer les widgets
> - Un panneau d'explication des autres panneaux (documentation du logiciel)

Une question reste en suspend (car nous ne sommes pas encore assez avancés) : comment sélectionner/ajouter un panneau (en termes utilisateur) à une interface ?