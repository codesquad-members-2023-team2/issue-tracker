//
//  FilterListViewController.swift
//  IssueTracker
//
//  Created by 1 on 2023/05/18.
//

import UIKit

class FilterElementListViewController: UIViewController {
   @IBOutlet weak var collectionView: UICollectionView!
   
   var filterElement = FilterElementUseCase(users: <#[User]#>,
                                            labels: <#[Label]#>,
                                            milestones: <#[Milestone]#>)
   var delegate: DataSenderDelegate?
   
   override func viewDidLoad() {
      super.viewDidLoad()
      delegate?.receive().forEach {
         
      }
   }
   
   @IBAction func cancel(_ sender: Any) {
      self.dismiss(animated: true)
   }
   
   @IBAction func save(_ sender: Any) {
      self.dismiss(animated: true)
   }
}
