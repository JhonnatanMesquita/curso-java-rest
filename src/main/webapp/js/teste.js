var palavra = "batata";

for (var i = 0; i < palavra.length; i++){
    for(var b = i+1; b< palavra.length; b++){
        if(palavra.charAt(i) == palavra.charAt(b)){
            palavra.substr(b, 1);
            palavra.substr(i, 1);
            i -= 1
        }
    }
}


console.log(palavra)