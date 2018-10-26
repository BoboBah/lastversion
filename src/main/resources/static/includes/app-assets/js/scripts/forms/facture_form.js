//nav-tabs 0
var next0 = document.getElementById('next0');

//nav-tabs 1
var prec1 = document.getElementById('prec1');
var next1 = document.getElementById('next1');

//nav-tabs 2
var prec2 = document.getElementById('prec2');
var next2 = document.getElementById('next2');

//nav-tabs 3
var prec3 = document.getElementById('prec3');
var next3 = document.getElementById('next3');

// Gestion des Evenements
next0.onclick= function(){
	
	//var b_nom=document.getElementById('b_nom').value;
	//alert('Beneficiaire'+b_nom);
	document.getElementById("check1").classList.remove("collapse");
	//alert('next0');
};

prec1.onclick= function(){
	//alert('prec1');
};

next1.onclick= function(){
	document.getElementById("check2").classList.remove("collapse");
	//alert('next1');
};

prec2.onclick= function(){
	//alert('prec2');
};

next2.onclick= function(){
	document.getElementById("check3").classList.remove("collapse");
	//alert('next2');
};

prec3.onclick= function(){
	//alert('prec3');
};

next3.onclick= function(){
	document.getElementById("check4").classList.remove("collapse");
	//alert('next3');
};
