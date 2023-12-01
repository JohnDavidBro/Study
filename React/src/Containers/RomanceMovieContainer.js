import React, { useState, useEffect, useMemo } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { getRomance } from '../modules/movie';
import MovieListSlider from 'movie/MovieListSlider';
import MovieList from 'movie/MovieList';

const RomanceMovieContainer = () => {
 
    const movies = useSelector(state => state.romance.movies);
    const romanceData = useMemo(() => movies || [], [movies]);
    const dispatch = useDispatch();

    const [images, setImages] = useState({});
    
    async function getImage(id) {
        const response = await fetch(`http://localhost:8080/movie/anonymous/listMoviePost/${id}`);
        const data = await response.json();
        return `https://www.themoviedb.org/t/p/original/${data[0]?.filePath}`
    }
    

    useEffect(() => {
        romanceData.forEach(async movie => {
            const image = await getImage(movie.id);
            setImages(prev => ({ ...prev, [movie.id]: image }));
        });
    }, [romanceData]);

    useEffect(() => {
        dispatch(getRomance());
    }, [dispatch]);
    return (
        <>
            <h3>로맨스 영화</h3>
            <MovieList>
                { romanceData && romanceData?.map(movie => (
                    <MovieListSlider
                        adult={movie.adult}
                        id={movie.id}
                        genreNames={movie.genre_names}
                        title={movie.title}
                        average={movie.vote_average}
                        overview={movie.overview}
                        poster={images[movie.id]}
                        date={movie.release_date}
                        backImg={movie.backdrop_path} 
                    />
                ))}
            
            </MovieList>
        </>
    )
}

export default RomanceMovieContainer;