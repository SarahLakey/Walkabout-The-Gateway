let appName = "Walkabout the Gateway";

        google.charts.load("current", {
          "packages":["map"],

          "mapsApiKey": "AIzaSyD4EMSLU3zejs7I5l--s6YTyNuzbz2Anz4"
        });
         google.charts.setOnLoadCallback(drawChart);
      function drawChart() {

      let data = google.visualization.arrayToDataTable([
                ['Lat', 'Long', 'Name'],
                [38.6270,  -90.1994, 'St. Louis'],
                [38.65214508187943, -90.2595139, 'LaunchCode'],
              ]);

 if(navigator.geolocation){
      navigator.geolocation.getCurrentPosition(function (position){
      initialLocation = new google.maps.LatLng(position.coords.latitude, position.coords.longitude)
      map.setCenter(initialLocation)})
      }

        let map = new google.visualization.Map(document.getElementById('map_div'));
        map.draw(data, {
          showTooltip: true,
          showInfoWindow: true
        });

      }