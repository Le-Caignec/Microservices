![Alt text](https://comunytek.com/wp-content/uploads/2017/03/Microservices.png)

# Microservice Application

Le but de ce projet était de créer une application simple basée sur l’architecture des microservices. Pour cela nous avons donc décidé de créer un site WEB permettant d’afficher d’une part du Markdown sous forme HTML et d’autre part du Latex sous forme HTML. Une gestion de l’historique a également été mise en place afin d’incorporer à notre application une interaction avec une base donnée. L'utilisateur pourra donc voir partiellement l’ensemble de ces anciennes requêtes et cliquer dessus afin d'en revoir une en particulier.

## Pour commencer

Dezipper le projet microservice. Puis ouvrer le projet via un IDE (_exemple_: IntelliJ IDEA, Visual Studio code) puis rendez-vous le terminal de votre IDE et placez-vous a la racine de notre projet. 

### Pré-requis
![Alt text](https://miro.medium.com/max/453/1*QVFjsW8gyIXeCUJucmK4XA.png)

Pour pouvoir lancer notre application il est necessaire d'avoir Docker et Docker Compose. Sinon vous ne les possèdez pas déjà rendez-vous sur le lien suivant: [Install Docker Desktop](https://docs.docker.com/desktop/windows/install/) puis installer Docker Desktop.


### Lancement de l'application

Suivez les etapes suivantes pour lancer l'appliaction

- Rendez-vous dans le terminal de votre IDE et placez vous à la racine du projet. 
  
- Tapez la commande suivante dans votre terminal : ``docker-compose up``
  
- Enter http://localhost:8080/ dans votre navigateur pour voir l'application en fonctionnement.
  

## Information supplémentaire

Vous pouvez vous rendre dans l'application Docker Desktop pour voir le conteneur global : MICROSERVICES et ces 4 sous conteneurs correspondants respectivement un miroservices comme le montre l'image ci-dessous. Vous pouvez ainsi relancer/arrter le conteneurs gloabal

![Alt text](screenReadme.png?raw=true)
