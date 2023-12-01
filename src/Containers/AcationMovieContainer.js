import React, { useState, useEffect, useMemo } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { getAction } from '../modules/movie';
import MovieListSlider from '../movie/MovieListSlider';
import MovieList from '../movie/MovieList';

const ActionMovieContainer = () => {

    const movies = useSelector(state => state.action.movies);
    const actionData = useMemo(() => movies || [], [movies]);
    const dispatch = useDispatch();

    const [images, setImages] = useState({});
    
    async function getImage(id) {
        const response = await fetch(`http://localhost:8080/movie/anonymous/listMoviePost/${id}`);
        const data = await response.json();
        return `https://www.themoviedb.org/t/p/original/${data[0]?.filePath}`
    }
    

    useEffect(() => {
        actionData.forEach(async movie => {
            const image = await getImage(movie.id);
            setImages(prev => ({ ...prev, [movie.id]: image }));
        });
    }, [actionData]);

    useEffect(() => {
        dispatch(getAction());
    }, [dispatch]);
    return (
        <>
            <h3>액션 영화</h3>
            <MovieList>
                { actionData && actionData?.map(movie => (
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

export default ActionMovieContainer;