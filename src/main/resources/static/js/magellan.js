function go(url) {
    console.log("goto -> " + url);

    $.ajax({
        url: url,
        error: function (xhr) {
            console.log("Une erreur a été détectée : " + xhr.status + " " + xhr.statusText);
            //magellanModalApp.displaySuccess("titre", "message", "pied");
            $("#snackbar").html("Une erreur a été détectée : " + xhr.status + " " + xhr.statusText);
            $("#snackbar").addClass("show");
            
            setTimeout(function() { $("#snackbar").removeClass("show"); }, 3000);
        }
    });
}