let appName = "Walkabout the Gateway";

window.addEventListener('load', function() {

const myForm = document.getElementById('myForm');

//myForm.addEventListener('click', function(event)){

        function openForm() {
          document.getElementById("myForm").style.display = "block";
        }

        function closeForm() {
          document.getElementById("myForm").style.display = "none";
        }

        window.openForm = openForm;
        window.closeForm = closeForm;

  //    });

});
