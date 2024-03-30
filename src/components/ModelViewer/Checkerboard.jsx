import { useEffect, useRef } from 'react';
import * as THREE from 'three';
import { TrackballControls } from 'three/examples/jsm/controls/TrackballControls';

function Checkerboard() {
    const containerRef = useRef(null);

    useEffect(() => {
        const scene = new THREE.Scene();
        const camera = new THREE.PerspectiveCamera(45, window.innerWidth / window.innerHeight, 0.1, 100);
        camera.position.set(0, 10, 20);
        camera.lookAt(scene.position);

        const renderer = new THREE.WebGLRenderer({ alpha: true });
        renderer.setSize(1500, 1500); // Ajusta el tamaño del renderizador
        renderer.domElement.style.width = '100%';
        renderer.domElement.style.height = '100%';
        renderer.setClearColor(0x000000, 0);
        containerRef.current.appendChild(renderer.domElement);

        const boardSize = 8;
        const tileSize = 1.3; // Tamaño de los cuadrados del tablero
        const pieceRadius = tileSize / 2.5; // Radio de las fichas

        // Crear tablero
        const board = new THREE.Group();
        for (let i = 0; i < boardSize; i++) {
            for (let j = 0; j < boardSize; j++) {
                const geometry = new THREE.BoxGeometry(tileSize, 0.2, tileSize);
                const material = new THREE.MeshBasicMaterial({ color: (i + j) % 2 === 0 ? 0xFAEDDB : 0xBB613D });
                const tile = new THREE.Mesh(geometry, material);
                tile.position.set(
                    i * tileSize - (boardSize / 2) * tileSize + tileSize / 2,
                    0,
                    j * tileSize - (boardSize / 2) * tileSize + tileSize / 2
                );
                board.add(tile);
            }
        }
        scene.add(board);

        // Crear fichas
        const pieces = new THREE.Group();
        const pieceGeometry = new THREE.CylinderGeometry(pieceRadius, pieceRadius, 0.4, 32);
        const blackMaterial = new THREE.MeshBasicMaterial({ color: 0x3c1002 });
        const whiteMaterial = new THREE.MeshBasicMaterial({ color: 0xdca658 });

        for (let i = 0; i < boardSize; i++) {
            for (let j = 0; j < 3; j++) {
                if ((i + j) % 2 !== 0) {
                    const blackPiece = new THREE.Mesh(pieceGeometry, blackMaterial);
                    blackPiece.position.set(
                        i * tileSize - (boardSize / 2) * tileSize + tileSize / 2,
                        0.2,
                        j * tileSize - (boardSize / 2) * tileSize + tileSize / 2
                    );
                    pieces.add(blackPiece);
                }
            }
        }

        for (let i = 0; i < boardSize; i++) {
            for (let j = boardSize - 3; j < boardSize; j++) {
                if ((i + j) % 2 !== 0) {
                    const whitePiece = new THREE.Mesh(pieceGeometry, whiteMaterial);
                    whitePiece.position.set(
                        i * tileSize - (boardSize / 2) * tileSize + tileSize / 2,
                        0.2,
                        j * tileSize - (boardSize / 2) * tileSize + tileSize / 2
                    );
                    pieces.add(whitePiece);
                }
            }
        }

        scene.add(pieces);

        // Controles de cámara
        const trackballControls = new TrackballControls(camera, renderer.domElement);
        trackballControls.rotateSpeed = 1.0;
        trackballControls.zoomSpeed = 0; // Deshabilitar zoom
        trackballControls.panSpeed = 0.8;
        trackballControls.noZoom = true; // Deshabilitar zoom
        trackballControls.noPan = false;
        trackballControls.staticMoving = true;
        trackballControls.dynamicDampingFactor = 0.3;

        // Animación
        const animate = () => {
            requestAnimationFrame(animate);
            scene.rotation.y += 0.001;
            trackballControls.update();
            renderer.render(scene, camera);
        };

        animate();

        return () => {
            // eslint-disable-next-line react-hooks/exhaustive-deps
            containerRef.current.removeChild(renderer.domElement);
            trackballControls.dispose();
        };
    }, []);

    return <div ref={containerRef} />;
}

export default Checkerboard;
