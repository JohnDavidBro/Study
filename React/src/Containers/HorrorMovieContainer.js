import React, { useState, useEffect, useMemo } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { getHorror } from '../modules/movie';
import MovieListSlider from 'movie/MovieListSlider';
import MovieList from 'movie/MovieList';

const HorrorMovieContainer = () => {
 
    const movies = useSelector(state => state.horror.movies);
    const horrorData = useMemo(() => movies || [], [movies]);
    const dispatch = useDispatch();

    const [images, setImages] = useState({});
    
    async function getImage(id) {
        const response = await fetch(`http://localhost:8080/movie/anonymous/listMoviePost/${id}`);
        const data = await response.json();
        return `https://www.themoviedb.org/t/p/original/${data[0]?.filePath}`
    }
    

    useEffect(() => {
        horrorData.forEach(async movie => {
            const image = await getImage(movie.id);
            setImages(prev => ({ ...prev, [movie.id]: image }));
        });
    }, [horrorData]);

    useEffect(() => {
        dispatch(getHorror());
    }, [dispatch]);
    return (
        <>
            <h3>공포 영화</h3>
            <MovieList>
                { horrorData && horrorData?.map(movie => (
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
export default HorrorMovieContainer;