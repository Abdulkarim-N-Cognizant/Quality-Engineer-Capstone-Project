import requests
import pytest

def test_get_all_posts():
    url = "https://jsonplaceholder.typicode.com/posts"
    response = requests.get(url)
    # 200 status code for successful  
    assert response.status_code == 200

    # check if the data being retrieved is the correct data type (list)
    data = response.json()
    assert isinstance(data,list)

    singlePost = data[0]

    # check if the data fields for a single post are valid
    assert 'id' in singlePost
    assert 'title' in singlePost
    assert 'body' in singlePost
    assert 'userId' in singlePost