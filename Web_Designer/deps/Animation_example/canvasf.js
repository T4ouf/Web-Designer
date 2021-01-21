"use strict";

window.onload = function()
{
    var canvas = document.getElementById('mon_canvas');
        if(!canvas)
        {
            alert("Impossible de récupérer le canvas");
            return;
        }

    var c = canvas.getContext('2d');
        if(!c)
        {
            alert("Impossible de récupérer le context du canvas");
            return;
        }

		
		//On n'oublie pas de récupérer le canvas et son context.

		
	//Partie boule
	
	var degrade = c.createLinearGradient(0,0,0,300);//Délimitation du début et de la fin du dégradé.
    degrade.addColorStop(0,"blue"); //Ajout d'une première couleur.
    degrade.addColorStop(1,"green");//Ajout de la seconde couleur.
		
	

	c.fillStyle = degrade;//On passe notre dégradé au fillStyle();
	
	var R=50;
    //C'est ici que l'on placera tout le code servant à nos dessins.
	c.beginPath(); //On démarre un nouveau tracé.
	c.arc(50, 50, R, 0, Math.PI*2); //On trace la courbe délimitant notre forme
	c.fill(); //On utilise la méthode fill(); si l'on veut une forme pleine
	c.closePath();
	
	/*
	//On n'oublie pas de récupérer l'objet canvas et son context.

	context.font = "18px Helvetica";//On passe à l'attribut "font" de l'objet context une simple chaîne de caractères composé de la taille de la police, puis de son nom.
	context.fillText("Hello World", 0, 30);//strokeText(); fonctionne aussi, vous vous en doutez.
	*/
	
	//30FPS
	var myInterval = setInterval(animate, 1000/30);
	
	var x=R;		//Position
	var y=R;
		
	var vx=17;		//Vitesse
	var vy=10;
	
	
	var decors= new Image();
	decors.src="forest.jpg";
	
	//Partie Pingouin
	
	var D0= new Image();
	D0.src="largetux-walk-right-0.png";
	var D1= new Image();
	D1.src="largetux-walk-right-1.png";
	var D2= new Image();
	D2.src="largetux-walk-right-2.png";
	var D3= new Image();
	D3.src="largetux-walk-right-3.png";
	var D4= new Image();
	D4.src="largetux-walk-right-4.png";
	var D5= new Image();
	D5.src="largetux-walk-right-5.png";
	
	var D= new Array;
	D=[D0,D1,D2,D3,D4,D5];
	
	var G0= new Image();
	G0.src="largetux-walk-left-0.png";
	var G1= new Image();
	G1.src="largetux-walk-left-1.png";
	var G2= new Image();
	G2.src="largetux-walk-left-2.png";
	var G3= new Image();
	G3.src="largetux-walk-left-3.png";
	var G4= new Image();
	G4.src="largetux-walk-left-4.png";
	var G5= new Image();
	G5.src="largetux-walk-left-5.png";
	
	var G= new Array;
	G=[G0,G1,G2,G3,G4,G5];
	
	var xp=5;
	var yp=382;//532;
	
	var id=0;
	var image=D[id];
	
	var ig=0;
	
	var touche_droite = false;
	var touche_gauche = false;
		
	function appuie(e) {
		if (e.keyCode == 39) touche_droite = true;
		if (e.keyCode == 37) touche_gauche = true;
		
	}
	
	window.addEventListener('keydown', appuie, false);
		
	function relache(e) {
		if (e.keyCode == 39) touche_droite = false;
		if (e.keyCode == 37) touche_gauche = false;
	}
	
	window.addEventListener('keyup', relache, false);
	
	function Droite(){
		
		
		if (touche_droite){
			ig=0;
			
			if(id==5){
				id=0;
			}
			else{
				id=id+1;
			}
			xp=xp+10;
			image=D[id];
		}
		
	}
	
	function Gauche(){
	
		
		if(touche_gauche){
			id=0;
			
			if(ig==5){
				ig=0;
			}
			
			else{
				ig=ig+1;
			}
			
			xp=xp-10;
			image=G[ig];
		}
		
	}
	
    function animate()
    {
        c.clearRect(0,0,canvas.width, canvas.height);	//On efface ce qui était déjà dessiné
		c.drawImage(decors,0,0);
		c.drawImage(decors,800,0);
		c.lineWidth=4;
		c.strokeRect(0,0,canvas.width,canvas.height);
		
			//On fait un cercle
		c.beginPath(); //On démarre un nouveau tracé.
		c.arc(x, y, R, 0, Math.PI*2); //On trace la courbe délimitant notre forme
		c.fill(); //On utilise la méthode fill(); si l'on veut une forme pleine
		c.closePath();
		
		if(x+vx>canvas.width-R || x+vx<R){
			vx=-vx;
		}
		if(y+vy>canvas.height-R || y+vy<R){
			vy=-vy;
		}
		var distance=Math.sqrt((xp-x)*(xp-x)+(yp-y)*(yp-y));
		if ( distance <= R ){
			vx=-vx;
			vy=-vy;
		}
		
		x=x+vx;
		y=y+vy;
		
		Droite();
		Gauche();
		c.drawImage(image,xp,yp);
		
    } 

}