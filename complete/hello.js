var data = "";

var xhr = new XMLHttpRequest();



xhr.addEventListener("readystatechange", function() {
    if(this.readyState === 4) {
        console.log(this.responseText);
    }
});

xhr.open("GET", "http://localhost:8080/api/users");





xhr.send(data);
console.log(data);