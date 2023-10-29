let liquidColor = "green"; // Initial liquid color is green

function setup() {
    // Create a canvas
    let canvas = createCanvas(400, 400);
    canvas.parent('canvas-container'); // Place canvas inside the container

    // Fetch the initial liquid color from the server (via GET request)
    fetchLiquidColor();
}

function draw() {
    // Draw the jar and liquid with the current liquid color
    background(240); // Background color
    drawJar();
    drawLiquid();
}

function drawJar() {
    // Draw the jar
    fill("green"); // Gray color for the jar
    rect(100, 100, 200, 200);
}

function drawLiquid() {
    // Draw the liquid with the current liquid color
    fill(liquidColor);
    rect(100, 100, 200, 200);
}

function mousePressed() {
    // Fetch the new liquid color from the server (via GET request)
    fetchLiquidColor();
}

function fetchLiquidColor() {
    // Generate a random value between 0 and 255 for red component
    const redValue = Math.floor(Math.random() * 256);
    
    // Generate a color gradient between green and red
    liquidColor = `rgb(${255 - redValue}, ${redValue}, 0)`;
}
