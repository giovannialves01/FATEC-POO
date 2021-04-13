function mask(o, f) {
  setTimeout(function() {
    var v = mphone(o.value);
    if (v != o.value) {
      o.value = v;
    }
  }, 1);
}

function mphone(v) {
  var r = v.replace(/\D/g, "");
  r = r.replace(/^0/, "");
  if (r.length > 10) {
    r = r.replace(/^(\d\d)(\d{5})(\d{4}).*/, "($1) $2-$3");
  } else if (r.length > 5) {
    r = r.replace(/^(\d\d)(\d{4})(\d{0,4}).*/, "($1) $2-$3");
  } else if (r.length > 2) {
    r = r.replace(/^(\d\d)(\d{0,5})/, "($1) $2");
  } else {
    r = r.replace(/^(\d*)/, "($1");
  }
  return r;
}

function mascaraData(val) {
  var pass = val.value;
  var expr = /[0123456789]/;

  for (i = 0; i < pass.length; i++) {
    // charAt -> retorna o caractere posicionado no índice especificado
    var lchar = val.value.charAt(i);
    var nchar = val.value.charAt(i + 1);

    if (i == 0) {
      // search -> retorna um valor inteiro, indicando a posição do inicio da primeira
      // ocorrência de expReg dentro de instStr. Se nenhuma ocorrencia for encontrada o método retornara -1
      // instStr.search(expReg);
      if ((lchar.search(expr) != 0) || (lchar > 3)) {
        val.value = "";
      }

    } else if (i == 1) {

      if (lchar.search(expr) != 0) {
        // substring(indice1,indice2)
        // indice1, indice2 -> será usado para delimitar a string
        var tst1 = val.value.substring(0, (i));
        val.value = tst1;
        continue;
      }

      if ((nchar != '/') && (nchar != '')) {
        var tst1 = val.value.substring(0, (i) + 1);

        if (nchar.search(expr) != 0)
          var tst2 = val.value.substring(i + 2, pass.length);
        else
          var tst2 = val.value.substring(i + 1, pass.length);

        val.value = tst1 + '/' + tst2;
      }

    } else if (i == 4) {

      if (lchar.search(expr) != 0) {
        var tst1 = val.value.substring(0, (i));
        val.value = tst1;
        continue;
      }

      if ((nchar != '/') && (nchar != '')) {
        var tst1 = val.value.substring(0, (i) + 1);

        if (nchar.search(expr) != 0)
          var tst2 = val.value.substring(i + 2, pass.length);
        else
          var tst2 = val.value.substring(i + 1, pass.length);

        val.value = tst1 + '/' + tst2;
      }
    }

    if (i >= 6) {
      if (lchar.search(expr) != 0) {
        var tst1 = val.value.substring(0, (i));
        val.value = tst1;
      }
    }
  }

  if (pass.length > 10)
    val.value = val.value.substring(0, 10);
  return true;
}

	function aumentaPe() {		
		var contador = document.getElementById("cliente.numPes").value;
		console.log(contador);
		contador++;

	document.getElementById("cliente.numPes").value = contador;
}
	function diminuiPe() {		
		var contador = document.getElementById("cliente.numPes").value;
		console.log(contador);
		contador--;

	document.getElementById("cliente.numPes").value = contador;
}
	function aumentaMao() {		
		var contador = document.getElementById("cliente.numMaos").value;
		console.log(contador);
		contador++;

	document.getElementById("cliente.numMaos").value = contador;
}
	function diminuiMao() {		
		var contador = document.getElementById("cliente.numMaos").value;
		console.log(contador);
		contador--;

	document.getElementById("cliente.numMaos").value = contador;
}

	function aumentaSomb() {		
		var contador = document.getElementById("cliente.numSobrancelhas").value;
		console.log(contador);
		contador++;

	document.getElementById("cliente.numSobrancelhas").value = contador;
}
	function diminuiSomb() {		
		var contador = document.getElementById("cliente.numSobrancelhas").value;
		console.log(contador);
		contador--;

	document.getElementById("cliente.numSobrancelhas").value = contador;
}

	function aumentaCabelo() {		
		var contador = document.getElementById("cliente.numCabelos").value;
		console.log(contador);
		contador++;

	document.getElementById("cliente.numCabelos").value = contador;
}
	function diminuiCabelo() {		
		var contador = document.getElementById("cliente.numCabelos").value;
		console.log(contador);
		contador--;

	document.getElementById("cliente.numCabelos").value = contador;
}

	function mediaIdade(){
		var idade_clientes = cr.mediaIdade;
		return console.log(idade_clientes);
	}
		