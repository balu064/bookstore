/*
 * Created on 3 avr. 2014 ( Time 19:39:42 )
 * Generated by Telosys Tools Generator ( version 2.1.0 )
 */
package org.demo.business.service.mapping;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.demo.bean.Book;
import org.demo.bean.jpa.BookEntity;
import org.demo.bean.jpa.AuthorEntity;
import org.demo.bean.jpa.PublisherEntity;
import org.demo.test.MockValues;

/**
 * Test : Mapping between entity beans and display beans.
 */
public class BookServiceMapperTest {

	private BookServiceMapper bookServiceMapper;

	private static ModelMapper modelMapper = new ModelMapper();

	private MockValues mockValues = new MockValues();
	
	
	@BeforeClass
	public static void setUp() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}
	
	@Before
	public void before() {
		bookServiceMapper = new BookServiceMapper();
		bookServiceMapper.setModelMapper(modelMapper);
	}
	
	/**
	 * Mapping from 'BookEntity' to 'Book'
	 * @param bookEntity
	 */
	@Test
	public void testMapBookEntityToBook() {
		// Given
		BookEntity bookEntity = new BookEntity();
		bookEntity.setIsbn(mockValues.nextString(13));
		bookEntity.setTitle(mockValues.nextString(160));
		bookEntity.setPrice(mockValues.nextBigDecimal());
		bookEntity.setQuantity(mockValues.nextInteger());
		bookEntity.setDiscount(mockValues.nextInteger());
		bookEntity.setAvailability(mockValues.nextShort());
		bookEntity.setBestSeller(mockValues.nextShort());
		bookEntity.setAuthor(new AuthorEntity());
		bookEntity.getAuthor().setId(mockValues.nextInteger());
		bookEntity.setPublisher(new PublisherEntity());
		bookEntity.getPublisher().setCode(mockValues.nextInteger());
		
		// When
		Book book = bookServiceMapper.mapBookEntityToBook(bookEntity);
		
		// Then
		assertEquals(bookEntity.getIsbn(), book.getIsbn());
		assertEquals(bookEntity.getTitle(), book.getTitle());
		assertEquals(bookEntity.getPrice(), book.getPrice());
		assertEquals(bookEntity.getQuantity(), book.getQuantity());
		assertEquals(bookEntity.getDiscount(), book.getDiscount());
		assertEquals(bookEntity.getAvailability(), book.getAvailability());
		assertEquals(bookEntity.getBestSeller(), book.getBestSeller());
		assertEquals(bookEntity.getAuthor().getId(), book.getAuthorId());
		assertEquals(bookEntity.getPublisher().getCode(), book.getPublisherId());
	}
	
	/**
	 * Test : Mapping from 'Book' to 'BookEntity'
	 */
	@Test
	public void testMapBookToBookEntity() {
		// Given
		Book book = new Book();
		book.setIsbn(mockValues.nextString(13));
		book.setTitle(mockValues.nextString(160));
		book.setPrice(mockValues.nextBigDecimal());
		book.setQuantity(mockValues.nextInteger());
		book.setDiscount(mockValues.nextInteger());
		book.setAvailability(mockValues.nextShort());
		book.setBestSeller(mockValues.nextShort());
		book.setAuthorId(mockValues.nextInteger());
		book.setPublisherId(mockValues.nextInteger());

		BookEntity bookEntity = new BookEntity();
		
		// When
		bookServiceMapper.mapBookToBookEntity(book, bookEntity);
		
		// Then
		assertEquals(book.getIsbn(), bookEntity.getIsbn());
		assertEquals(book.getTitle(), bookEntity.getTitle());
		assertEquals(book.getPrice(), bookEntity.getPrice());
		assertEquals(book.getQuantity(), bookEntity.getQuantity());
		assertEquals(book.getDiscount(), bookEntity.getDiscount());
		assertEquals(book.getAvailability(), bookEntity.getAvailability());
		assertEquals(book.getBestSeller(), bookEntity.getBestSeller());
		assertEquals(book.getAuthorId(), bookEntity.getAuthor().getId());
		assertEquals(book.getPublisherId(), bookEntity.getPublisher().getCode());
	}

}