
class RoomCard{

    constructor(sala){
        this.sala = sala;
    }

    

     render(){

        const fotoDiv = document.createElement('div');
        fotoDiv.className = 'foto';

        const card = document.createElement('div');
        card.className = 'card mb-3';
        card.style.width = '80%';
          
        const cardImg = document.createElement('img');
        cardImg.className = 'card-img-top';
        cardImg.src = 'Imagenes/SalonDefault.jpeg';
        card.appendChild(cardImg);
      
        const cardBody = document.createElement('div');
        cardBody.className = 'card-body';
        cardBody.style.justifyContent = 'center';
        cardBody.style.alignItems = 'center';
    
        const cardTitle = document.createElement('h2');
        cardTitle.className = 'card-title';
        cardTitle.textContent = this.sala.numSala;
        cardBody.appendChild(cardTitle);
    
        const featuresList = document.createElement('ul');
    
        const feature1 = document.createElement('li');
        feature1.id = 'item1';
        feature1.textContent = "Capacidad: "+this.sala.capacidad + " personas";
        featuresList.appendChild(feature1);
    
        const feature2 = document.createElement('li');
        feature2.id = 'item2';
        feature2.textContent = "Recursos: "+this.sala.recursos ;
        featuresList.appendChild(feature2);

        fotoDiv.appendChild(cardBody);
        featuresList.appendChild(feature2) ;
        featuresList.appendChild(feature1)   ;
        card.appendChild(fotoDiv) ;
        card.appendChild(featuresList)




        return card ;
      }   

      action(event){
        event.preventDefault() ;  //Previene Ejecución de accion por defecto       
        



    }


    }

