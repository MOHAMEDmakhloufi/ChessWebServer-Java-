# ChessWebServer-Java-
Fondements des syst`emes distribu ́es
Projet : Distribution d’un jeu en java

1 Informations g ́en ́erales
L’objectif de ce projet est de vous permettre de distribuer une application java. Ceci vous
permet de vous exercer sur la programmation distribu ́ee et de vous rendre compte de certains
probl`emes li ́es `a la distribution ; en particulier le probl`eme de synchronisation et d’accord
distribu ́e. Vous pouvez vous mettre en groupe d’au plus quatre  ́etudiants. Le volume de travail
attendu de chaque groupe est proportionnel au nombre d’ ́etudiants qui le composent.
2 Travail `a faire
2.1 Code de d ́epart
Vous allez partir d’un code d ́ej`a existant, par exemple celui du jeu Tic Tac Toe ou du
fameux snake. Vous pouvez  ́egalement choisir un autre jeu et partir d’un autre code (vous
devez citer la source). Vous pouvez  ́egalement d ́evelopper votre propre jeu.
2.2 Nombre de joueurs
Vous devez faire en sorte que le jeu supporte plusieurs utilisateurs. Deux joueurs est le
strict minimum. Cependant, faire en sorte que votre jeu supporte trois joueurs ou plus est
vivement conseill ́e. Vous pouvez imaginer le jeu Tic Tac Toe avec une grille plus grande et un
nombre plus important de joueurs. Pour snake vous pouvez imaginer un serpent pour chaque
joueur.
2.3 Distribution
2.3.1 Repr ́esentation des actions
La tˆache essentielle est de transporter les actions de chaque joueur depuis sa machine vers
les machines des autres joueurs. Il faut tout d’abord d ́efinir ce qu’on entend par action, ceci
d ́epend de votre jeu et peu ˆetre un clic de souris, un clic sur une touche particuli`ere du clavier.
A vous de faire le choix de la repr ́esentation des actions. Pour faciliter le transport, vous
pouvez utiliser la s ́erialisation java et les ObjectInputStream et ObjectOutputStream.
2.3.2 Architecture de l’application
Vous pouvez choisir parmi ces trois options :
— Un serveur central s’occupe de la propagation de tous les  ́ev`enements.
— Un joueur particulier joue aussi le rˆole du serveur.
— Tous les joueurs agissent `a la fois comme clients et serveurs.
Pour tester vous pouvez utiliser une ou plusieurs machines.



2.3.3 Protocoles de transport
Vous pouvez choisir parmi ces cinq options :
— TCP
— UDP
— Multicast
— RMI
— JMS
2.3.4 Conclusion
Il y a plusieurs choix `a faire, en fonction de vos objectifs, vous pouvez faire des mesures
de performances et des analyses comparatives.
3 D ́e-livrables
Chaque groupe doit rendre un fichier zip contenant le code source, un fichier README,

et un document pdf contentant toutes les informations d ́ecrivant la solution propos ́ee et per-
mettant de comprendre comment vous avez pu arriver `a votre proposition. Il est vivement

conseill ́e de consulter et de s’inspirer de la documentation en ligne et mˆeme des codes de
solutions aux probl`emes similaires `a ceux que vous  ́etudiez. Cependant, il faut citer toutes les
sources utilis ́ees. Il est strictement interdit de copier du code ou du texte  ́ecrit par les autres
groupes.
