window.addEventListener('load', function() {

        function openForm() {
              document.getElementById("myForm").style.display = "block";
            }

            function closeForm() {
              document.getElementById("myForm").style.display = "none";
            }

  const nameInput = document.getElementById('name-input');
  const locationInput = document.getElementById('location-input');
  const factInput = document.getElementById('fact-input');

  const form = document.querySelector('myForm');

 nameInput.addEventListener('input', function() {
    name.innerHTML = nameInput.value || "Name";
  });

 locationInput.addEventListener('input', function() {
      location.innerHTML = locationInput.value || "Location";
    });

 factInput.addEventListener('input', function() {
        fact.innerHTML = factInput.value || "Fact To Be Verified";
      });

  }