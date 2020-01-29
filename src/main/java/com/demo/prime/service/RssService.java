package com.demo.prime.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.prime.domain.Rss;
import com.demo.prime.repository.RssRepository;

@Service
public class RssService {
	
	@Autowired
	private RssRepository rssRepository;
	
	public Rss save(Rss rss) {
		return rssRepository.save(rss);
	}
	
	public void excluir(Long rssId) {
		rssRepository.deleteById(rssId);
	}
	
	public Rss findById(Long rssId) {
		return rssRepository.findById(rssId).get();
	}
	
	public List<Rss> findAll(){
		return rssRepository.findAll();
	}
	
}
