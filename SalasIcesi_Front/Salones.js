class Salones{

    constructor(salon){
        this.salon = salon;
    }

    render(){
        let container = document.createElement('div'); //<div></div>
        container.classList.add('btn-primary');

        let title = document.createElement('h5');
        title.classList.add('card-title');

        let button = document.createElement('a') ;
        button.classList.add('btn') ;
        button.classList.add('btn-primary') ;
        button.setAttribute('href', '#') ; 
        button.innerHTML = "Ver Detalles"
        

        let description = document.createElement('p') ;


        cardbody.appendChild(title);
        cardbody.appendChild(button ) ;
        cardbody.appendChild(description) ;
        container.appendChild(img);
        container.appendChild(cardbody);

        title.innerHTML = this.user.username;

        button.addEventListener('click', this.action.bind(this)) ;


        return container;
    }

    action(event){
        event.preventDefault() ;  //Previene Ejecución de accion por defecto       
        alert(this.user.username) ;
        window.localStorage.setItem('userClicked', JSON.stringify(this.user)) ;
        window.location.href  = '/userDetail.html'




    }


}