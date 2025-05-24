function go(url) {
    console.log("goto -> " + url);


    $("#main-content").load(url, function(responseText, textStatus, xhr) {
       if (textStatus === "error") {
           console.log("Une erreur a été détectée : " + xhr.status + " " + xhr.statusText);
            $("#snackbar").html("Une erreur a été détectée : " + xhr.status + " " + xhr.statusText);
            $("#snackbar").addClass("show");
            setTimeout(function() { $("#snackbar").removeClass("show"); }, 3000);
       } 
    });
}