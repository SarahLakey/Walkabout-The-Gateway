function getLocation(){

 //let currentLocation = document.getElementById("location");

  const success = (position) => {
       const longitude = position.coords.longitude;
       const latitude = position.coords.latitude;
       document.getElementById("location").innerHTML = 'You are currently at ${longitude}, ${latitude}! \n Longitude is the first number, latitude is the second number.';
       alert('You are currently at ${longitude}, ${latitude}! \n Longitude is the first number, latitude is the second number.');
       };

      const geoLocation = () => {
      if(navigator.geolocation){
      navigator.geolocation.getCurrentPosition(success);
      } else {
      document.getElementById("location").innerHTML = 'Your browser does not support our geolocation service.';
      alert('Your browser does not support our geolocation service.');};
      };

    // currentLocation.style.display;

      }
