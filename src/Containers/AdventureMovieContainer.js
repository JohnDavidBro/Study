import React, { useState, useEffect, useMemo } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { getAdventure } from '../modules/movie';
import MovieListSlider from '../movie/MovieListSlider';
import MovieList from '../movie/MovieList';

const AdventureMovieContainer = () => {

    const movies = useSelector(state => state.adventure.movies);
    const adventureData = useMemo(() => movies || [], [movies]);
    const dispatch = useDispatch();

    const [images, setImages] = useState({});
    
    async function getImage(id) {
        const response = await fetch(`http://localhost:8080/movie/anonymous/listMoviePost/${id}`);
        const data = await response.json();
        return `https://www.themoviedb.org/t/p/original/${data[0]?.filePath}`
    }
    

    useEffect(() => {
        adventureData.forEach(async movie => {
            const image = await getImage(movie.id);
            setImages(prev => ({ ...prev, [movie.id]: image }));
        });
    }, [adventureData]);

    useEffect(() => {
        dispatch(getAdventure());
    }, [dispatch]);
    return (
        <>
            <h3>모험 영화</h3>
            <MovieList>
                { adventureData && adventureData?.map(movie => (
                    <MovieListSlider
                        adult={movie.adult}
                        id={movie.id}
                        genreNames={movie.genre_names}
                        title={movie.title}
                        average={movie.vote_average}
                        overview={movie.overview}
                        poster={images[movie.id]}
                        date={movie.release_date}

                    />
                ))}
            
            </MovieList>
        </>
    )
}

export default AdventureMovieContainer;