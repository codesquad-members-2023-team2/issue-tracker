//
//  IssueCell.swift
//  IssueTracker
//
//  Created by 1 on 2023/05/11.
//

import UIKit

class IssueListCollectionViewCell: UICollectionViewCell {
   static var cellId: String = "IssueListCollectionViewCell"
   let imageInset = UIEdgeInsets(top: -7, left: -7, bottom: -7, right: -7)
   
   @IBOutlet var titleLabel: UILabel!
   @IBOutlet var checkBoxImageView: UIImageView!
   @IBOutlet var descriptionLabel: UILabel!
   @IBOutlet var milestoneLabel: UILabel!
   @IBOutlet var labelStackView: UIStackView!
   @IBOutlet weak var labelStackContainer: UIView!
   
   override func awakeFromNib() {
      super.awakeFromNib()
      configureFont()
      configureImage()
   }
   
   override func prepareForReuse() {
      super.prepareForReuse()
      labelStackContainer.isHidden = false
      emptyLabelStack()
   }
   
   func configureFont() {
      self.titleLabel.apply(typography: Typography(weight: .bold, size: .large),
                            textColor: .gray900)
      self.descriptionLabel.apply(typography: Typography(weight: .regular, size: .medium),
                                  textColor: .gray800)
      self.milestoneLabel.apply(typography: Typography(weight: .regular, size: .medium),
                                textColor: .gray800)
   }
   
   func configureImage() {
      guard let chevron = UIImage(systemName: "chevron.right") else { return }
      self.checkBoxImageView.image = chevron.withAlignmentRectInsets(imageInset)
   }
   
   func addLabel(name: String, color: String) {
      let label = IssueLabel(name: name, color: color)
      self.labelStackView.addArrangedSubview(label)
   }
   
   func emptyLabelStack() {
      labelStackView.arrangedSubviews.forEach { view in view.removeFromSuperview() }
   }
   
   func configure(issue: IssueSummary) {
      titleLabel.text = "#\(issue.issueId) \(issue.title)"
      descriptionLabel.text = issue.content
      milestoneLabel.text = issue.milestoneName
      
      if issue.labelList.isEmpty {
         labelStackContainer.isHidden = true
         return
      }
      
      for label in issue.labelList {
         addLabel(name: label.labelName, color: label.backgroundColor)
      }
      labelStackView.sizeToFit()
   }
   
   func didSelect() {
      let filledCheckmark = UIImage(systemName: "checkmark.circle.fill")
      self.checkBoxImageView.image = filledCheckmark?.withAlignmentRectInsets(imageInset)
      self.checkBoxImageView.tintColor = .systemBlue
      self.backgroundColor = Color.gray100.color
   }
   
   func didDeSelect() {
      configureImage()
      self.backgroundColor = .systemBackground
   }
}
