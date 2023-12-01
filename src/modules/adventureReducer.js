import { GET_ADVENTURE } from './movie';

export default function(state = [], adventure) {
    switch (adventure.type) {
        case GET_ADVENTURE:
            return {
                ...state,
                movies: adventure.data
            };
        default:
            return state;
    }
}