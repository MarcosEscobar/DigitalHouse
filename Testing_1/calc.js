function suma(a,b){
    if(!isNaN(a) && !isNaN(b)){
        return a+b;
    }
    return 0    
}

function resta(a,b){
    if(!isNaN(a) && !isNaN(b)){
        return a-b;
    }
    return 0    
}

function multiplicacion(a,b){
    if(!isNaN(a) && !isNaN(b)){
        return a*b;
    }
    return 0
}

function division(a,b){
    if(!isNaN(a) && !isNaN(b)){
        return a/b;
    }
    return 0 
}

module.exports = {suma, resta, multiplicacion, division};
