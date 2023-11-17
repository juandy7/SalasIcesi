class SalaCard {
    constructor (sala){
        this.sala = sala ;
    }

    render(){
        
        var container = document.createElement('div');
        container.className = 'container text-center';
        container.style.width = '5cm';

        
        var row = document.createElement('div');
        row.classList = 'row g-2';
        
        var col = document.createElement('div');
        col.className = 'col-6';
        
        var button = document.createElement('button');
        button.type = 'button';
        button.className = 'btn btn-primary btn-lg';
        button.innerText = this.sala.numSala;
        
        col.appendChild(button);
        row.appendChild(col);
        container.appendChild(row);
        
        document.body.appendChild(container);

        return container; 
        

    }

  


}