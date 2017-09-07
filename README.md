# en-jin
Simple 3D Game Engine written in Java

## Features

#### Core Engine
- Basic input systems
- GameObject inheritance and behavioral component support
- .obj mesh importing

#### Rendering Engine
- Frame rate capping
- Transformation, rotation and scaling of 3D meshes
- Orthographic and perspective camera angles
- Ambient lighting
- Point lights, spot lights, directional lighting
- Specular reflections

## Run

### Dependencies
[LWJGL 2.9.3](http://legacy.lwjgl.org/)

[Slick-Util](http://slick.ninjacave.com/slick-util/)

The repo is already set up as an IDEA project so you can use the .jar files inside the /lib directory if you prefer.

### Build
Import the project into your preferred IDE and set the Java path to include the /native directory for your operating system.

For convenience, you can run the project from the command line with:
```-Djava.library.path=*your_path_to_native*```
