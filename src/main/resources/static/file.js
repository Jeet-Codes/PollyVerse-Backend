import React from 'react';
import { Canvas } from '@react-three/fiber';
// import Box from './Box';
import * as  Model  from './Model';
import { OrbitControls } from '@react-three/drei';
import { obj } from './obj ';


function App() {
    // console.log(obj)

    return (
        <>
            <div style={{ width: '100vw', height: '100vh' }}>
                <Canvas>
                    <ambientLight />
                    <OrbitControls/>
                    <pointLight position={[10, 10, 10]} />
                    <Model.Model />
                </Canvas>
            </div>
            <div style={{ width: '100vw', height: '100vh' }}>
                <Canvas>
                    <ambientLight />
                    <OrbitControls/>
                    <pointLight position={[10, 10, 10]} />
                    <Model.Model1 />
                </Canvas>
            </div>
            <div style={{ width: '100vw', height: '100vh' }}>
                <Canvas>
                    <ambientLight />
                    <OrbitControls/>
                    <pointLight position={[10, 10, 10]} />
                    <Model.Model2/>
                </Canvas>
            </div>
            <div style={{ width: '100vw', height: '100vh' }}>
                <Canvas>
                    <ambientLight />
                    <OrbitControls/>
                    <pointLight position={[10, 10, 10]} />
                    <Model.Model />
                </Canvas>
            </div>
        </>
    );
}

export default App;
