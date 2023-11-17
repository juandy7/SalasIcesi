var container = document.createElement('div');
container.className = 'container text-center';

var row = document.createElement('div');
row.className = 'row g-2';

var col = document.createElement('div');
col.className = 'col-6';

var button = document.createElement('button');
button.type = 'button';
button.className = 'btn btn-primary btn-lg';
button.innerText = '101E1';

col.appendChild(button);
row.appendChild(col);
container.appendChild(row);

document.body.appendChild(container);