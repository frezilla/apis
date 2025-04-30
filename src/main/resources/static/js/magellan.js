function go(url) {
    console.log("goto -> " + url);

    $.ajax({
        url: url,
        error: function (xhr) {
            console.log("Une erreur a été détectée : " + xhr.status + " " + xhr.statusText);
        }
    });
}

const magellanModalApp = Vue.createApp({
    template:
    `
        <div class="magellan-modal-content">
            <div class="magellan-modal-header">
                <span class="magellan-modal-close">&times;</span>
                {{ title }}
            </div>
            <div class="magellan-modal-body">
                {{ message }}
            </div>
            <div class="magellan-modal-footer" style="background-color: {{ backgroundColor }}">
                {{ footer }}
            </div>
         </div>
    `,
    data() {
        return {
            backgroundColor: "red",
            message: "Hello World!",
            title: "Titre",
            footer: "footer"
        }
    },
    methods: {
        displaySuccess(title, message, footer) {
            this.footer = footer;
            this.message = message;
            this.title = title;
        }
    }
});

magellanModalApp.mount("#magellan-modal");