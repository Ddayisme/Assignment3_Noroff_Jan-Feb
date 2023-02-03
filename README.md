# spring-web-movie-application

[![standard-readme compliant](https://img.shields.io/badge/standard--readme-OK-green.svg?style=flat-square)](https://github.com/RichardLitt/standard-readme)

In this project we were two people who made a database which can be accessed through RESTful API calls using Spring. 

The program has a set of movies, characters and franchises that can through GET, PUT, POST and DELETE API calls view or edit what the database contains. 

The database is made so a character can play in multiple movies, and a movie contains multiple characters, while a movie is only in 1 franchise and a franchise has multiple movies. 

This project contains Swagger where you can see all the API calls that are available. 

TODO: Fill out this long description.

## Table of Contents

- [Install](#install)
- [Usage](#usage)
- [API](#api)
- [Maintainers](#maintainers)
- [Contributing](#contributing)
- [License](#license)

## Install

It is just a Spring Application, you download it, there is no wizard helping you here.

To start it you open it in your IDE of choice and click Run. It can now be accessed through API calls from for example Postman. 

## Usage

After having started the program, you can either use Postman or other programs that does API calls, and then start gathering information from the database. 

You can open up Swagger to see all the API calls available and what is required input for them. You can find Swagger at localhost:8080/swagger-ui.html

When creating something you only need to enter a name for franchise and character, or title for movie. To enter the other fields use the Put method. This might be what you talked about, Nick, where you would in front end do nested calls where you only do the minimal requirements for a POST and then flesh it out with a PUT. 

## API

Check Swagger for the API calls. localhost:8080/swagger-ui.html

## Maintainers

[@OddM91](https://github.com/OddM91)
[@Ddayisme](http://github.com/Ddayisme)

## Contributing

Small note: If editing the README, please conform to the [standard-readme](https://github.com/RichardLitt/standard-readme) specification.

## License

MIT © 2023 Odd Martin Kveseth & Eivind Skandsen
