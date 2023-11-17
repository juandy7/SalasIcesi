class SalaCard {
    constructor (sala){
        this.sala = sala ;
    }

    render(){
        
        var container = document.createElement('div');
        container.className = 'container text-center';
        container.style.width = '40%';

        
        var row = document.createElement('div');
        row.classList = 'row g-2';
        
        var col = document.createElement('div');
        col.className = 'col-6';
        
        var button = document.createElement('button');
        button.type = 'button';
        button.className = 'btn btn-primary btn-lg';
        button.innerText = this.sala.numSala;
        
        row.appendChild(button);
        col.appendChild(row);
        container.appendChild(col);
        
        document.body.appendChild(container);

        return container; 
        

         // Crear un contenedor div
         // Crear un contenedor div


         /*
  var containerDiv = document.createElement("div");
  containerDiv.classList.add("container", "overflow-hidden", "text-center");

  // Crear una fila div con gy-5 (gutters y-5) para el espaciado vertical
  var rowDiv = document.createElement("div");
  rowDiv.classList.add("row", "gy-5");

  // Crear un solo elemento que contiene botones y columnas
  var colDiv = document.createElement("div");
  colDiv.classList.add("col-6");


    var buttonDiv = document.createElement("div");
    buttonDiv.classList.add("p-3");

    var button = document.createElement("button");
    button.type = "button";
    button.classList.add("btn", "btn-primary", "btn-lg", "btn-block");
    button.textContent = this.sala.numSala

    // Agregar el botón al div interior
    buttonDiv.appendChild(button);

    // Agregar el div interior al contenedor de la columna
    colDiv.appendChild(buttonDiv);
  

  // Agregar la columna al contenedor de fila
  rowDiv.appendChild(colDiv);

  // Agregar la fila al contenedor
  containerDiv.appendChild(rowDiv);

  // Agregar el contenedor al cuerpo del documento
  document.body.appendChild(containerDiv);

  */

        return containerDiv;

    }

  


}


