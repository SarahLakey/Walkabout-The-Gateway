

  /*  function initMap(){
    map=new google.maps.Map(document.getElementId('map'), {
    center: {lat: 38.6270, lng:-90.1994}
    zoom: 4
    });*/

    let map;

    async function initMap() {
      const { Map } = await google.maps.importLibrary("maps");

      map = new Map(document.getElementById("map"), {
        center: { lat: 38.627, lng: -90.199 },
        zoom: 8,
      });
    }

    initMap();

         if(navigator.geolocation){
              navigator.geolocation.getCurrentPosition(function (position){
              initialLocation = new google.maps.LatLng(position.coords.latitude, position.coords.longitude)
              map.setCenter(initialLocation)})
              };
      }
